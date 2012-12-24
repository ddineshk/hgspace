package org.ddk.spring.store.hibernate.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static Log log = LogFactory.getLog(HibernateUtil.class);

	private static final String INTERCEPTOR_CLASS = "hibernate.util.interceptor_class";

	private static Configuration configuration;

	private static SessionFactory sessionFactory;

	static {
		try {

			configuration = new Configuration();
			configuration
					.configure("/org/ddk/spring/store/hibernate/utils/hibernate.cfg.xml");

			setInterceptor(configuration, null);

			if (configuration.getProperty(Environment.SESSION_FACTORY_NAME) != null) {
				configuration.buildSessionFactory();
			} else {
				sessionFactory = configuration.buildSessionFactory();
			}

		} catch (Throwable ex) {
			log.error("Building SessionFactory failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Configuration getConfiguration() {
		return configuration;
	}

	public static SessionFactory getSessionFactory() {
		SessionFactory sf = null;
		String sfName = configuration
				.getProperty(Environment.SESSION_FACTORY_NAME);
		if (sfName != null) {
			log.debug("Looking up SessionFactory in JNDI.");
			try {
				sf = (SessionFactory) new InitialContext().lookup(sfName);
			} catch (NamingException ex) {
				throw new RuntimeException(ex);
			}
		} else {
			sf = sessionFactory;
		}
		if (sf == null)
			throw new IllegalStateException("SessionFactory not available.");
		return sf;
	}

	public static void shutdown() {
		log.debug("Shutting down Hibernate.");
		getSessionFactory().close();

		configuration = null;
		sessionFactory = null;
	}

	public static void rebuildSessionFactory() {
		log.debug("Using current Configuration for rebuild.");
		rebuildSessionFactory(configuration);
	}

	public static void rebuildSessionFactory(Configuration cfg) {
		log.debug("Rebuilding the SessionFactory from given Configuration.");
		synchronized (sessionFactory) {
			if (sessionFactory != null && !sessionFactory.isClosed())
				sessionFactory.close();
			if (cfg.getProperty(Environment.SESSION_FACTORY_NAME) != null)
				cfg.buildSessionFactory();
			else
				sessionFactory = cfg.buildSessionFactory();
			configuration = cfg;
		}
	}

	public static SessionFactory registerInterceptorAndRebuild(
			Interceptor interceptor) {
		log.debug("Setting new global Hibernate interceptor and restarting.");
		setInterceptor(configuration, interceptor);
		rebuildSessionFactory();
		return getSessionFactory();
	}

	public static Interceptor getInterceptor() {
		return configuration.getInterceptor();
	}

	public static void resetInterceptor() {
		log.debug("Resetting global interceptor to configuration setting");
		setInterceptor(configuration, null);
	}

	private static void setInterceptor(Configuration configuration,
			Interceptor interceptor) {
		String interceptorName = configuration.getProperty(INTERCEPTOR_CLASS);
		if (interceptor == null && interceptorName != null) {
			try {
				Class interceptorClass = HibernateUtil.class.getClassLoader()
						.loadClass(interceptorName);
				interceptor = (Interceptor) interceptorClass.newInstance();
			} catch (Exception ex) {
				throw new RuntimeException("Could not configure interceptor: "
						+ interceptorName, ex);
			}
		}
		if (interceptor != null) {
			configuration.setInterceptor(interceptor);
		} else {
			configuration.setInterceptor(EmptyInterceptor.INSTANCE);
		}
	}

}