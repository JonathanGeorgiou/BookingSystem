var hairstyle = "";
function selectStyle() {
  const styleOptions = document.getElementsByName("optionsRadios");

  for (var i = 0; i < styleOptions.length; i++) {
    if (styleOptions[i].checked) {
      hairstyle = hairstyle + styleOptions[i].value;
      // alert("you selected " + hairstyle);
      // axios.post("http://localhost:8081/createBooking", {
      //   style: hairstyle,
      //   timeOfBooking: "2012-08-23T18:25:43.511"
      // });
    }

    location.assign("select-datetime.html");
    return hairstyle;
  }
}

function selectTime() {
  var hairstyle = selectStyle();
  var bookingTime = new Date($("#picker").val());
  alert(bookingTime);
  console.log(hairstyle);
  axios.patch("http://localhost:8081/updateBooking", {
    style: hairstyle,
    timeOfBooking: bookingTime
  });
  //location.assign("enter-details.html");
}
