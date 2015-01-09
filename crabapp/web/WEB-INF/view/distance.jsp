<script type="text/javascript" lang="javascript">
   $(document).ready(function() {
      $("#distanceSubmit").click(function(event){
          $.ajax({
        	  url:'https://maps.googleapis.com/maps/api/distancematrix/json?origins=12.943455,%2080.121836&destinations=13.082878,%2080.180982&key=AIzaSyD_a2HSusfpmN80CpUjd0wcN0G4EBaScdo',
              crossDomain:true,
              success: function(data) {
            	  alert(data);
              }
          });
      });
   });
   </script>

<div style="margin:10px;">
	<h3>Distance</h3>
	<table>
		<tr><td>Start: </td><td><input type="text" id="start"></td></tr>
		<tr><td>End  : </td><td><input type="text" id="end"></td></tr>
		<tr><td colspan="2"><input type="submit" id="distanceSubmit" value="Submit"/></td></tr>
	</table>
</div>