function testData() {

    getApi(function (response) {
        console.log(response);

        if (response == "success") {
            console.log("callback is working well");
        } else {
            console.log("call back not working");
        }
    });

    function getApi(callback) {
        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this.responseText);
                callback(this.responseText);
            }
        });

        xhr.open("GET", "http://localhost:7070/test");

        xhr.send();
    }

}
