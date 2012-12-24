package org.ddk.spring.store.domain;

public class Banner implements java.io.Serializable, Comparable<Object> {
	private static final long serialVersionUID = -7466200578701058993L;
	private Long id;
	private int version;
	private Category favCategory;
	private String bannerName;

	public Banner() {
	}

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public Category getFavCategory() {
		return favCategory;
	}

	public void setFavCategory(Category favCategory) {
		this.favCategory = favCategory;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Banner))
			return false;

		final Banner banner = (Banner) o;

		if (!getFavCategory().equals(banner.getFavCategory()))
			return false;
		if (!getBannerName().equals(banner.getBannerName()))
			return false;

		return true;
	}

	public int hashCode() {
		return getBannerName().hashCode();
	}

	public String toString() {
		return "Banner: " + getFavCategory().toString() + ", "+ "Banner Name: " + getBannerName();
	}

	public int compareTo(Object o) {
		if (o instanceof Banner) {
			return getBannerName().compareTo(((Banner) o).getBannerName());
		}
		return 0;
	}
}
