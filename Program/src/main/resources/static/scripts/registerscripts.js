/**
 * 
 */
 
  let captchaText = document.querySelector('#captcha');
        console.log(captchaText);
        var ctx = captchaText.getContext("2d");
        ctx.font = "30px Roboto";
        ctx.fillStyle = "#000C66";

        let userText = document.querySelector('#textBox');
        let submitButton = document.querySelector('#submitButton');
        let output = document.querySelector('#error');
        output.style.fontSize = "95%";output.style.color = "red";
        let refreshButton = document.querySelector('#reload-button');

        let alphaNums = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
        let emptyArr = [];

        for (let i = 1; i <= 7; i++) {
            emptyArr.push(alphaNums[Math.floor(Math.random() * alphaNums.length)]);
        }
        var c = emptyArr.join('');
        ctx.fillText(emptyArr.join(''),captchaText.width/4, captchaText.height/2);

        userText.addEventListener('keyup', function(e) {
            // Key Code Value of "Enter" Button is 13
            if (e.keyCode === 13) {
               if (userText.value === c) {
                    document.getElementById("submit").style.display = "initial";
                    output.innerHTML = "";
                }
                else{document.getElementById("submit").style.display = "none";
                output.innerHTML = "Incorrect, please try again";}
            }
        });

        submitButton.addEventListener('click', function() {
            if (userText.value === c) {
                document.getElementById("submit").style.display = "initial";
                output.innerHTML = "";
            }
            else{document.getElementById("submit").style.display = "none";
            output.innerHTML = "Incorrect, please try again";}
        });

        refreshButton.addEventListener('click', function() {
            userText.value = "";
            document.getElementById("submit").style.display = "none";
            let refreshArr = [];
            for (let j = 1; j <= 7; j++) {
                refreshArr.push(alphaNums[Math.floor(Math.random() * alphaNums.length)]);
            }
            ctx.clearRect(0, 0, captchaText.width, captchaText.height);
            c = refreshArr.join('');
            ctx.fillText(refreshArr.join(''),captchaText.width/4, captchaText.height/2);
            output.innerHTML = "";
        });
        
    function onSubmit(token) {
        document.getElementById("demo-form").submit();
      }
   