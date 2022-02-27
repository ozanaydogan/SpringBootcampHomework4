let container = document.getElementById('container')
// toggle = () => {
// 	container.classList.toggle('sign-in')
// 	container.classList.toggle('sign-up')
// }

function register(){
	setTimeout(() => {
		container.classList.add('sign-in')
	}, 100);
}
function login(){
	setTimeout(() => {
		container.classList.add('sign-up')
	}, 100);
}

if(document.getElementById("loginButton")!=undefined)
document.getElementById("loginButton").addEventListener("click", login());
if(document.getElementById("registerButton")!=undefined)
document.getElementById("registerButton").addEventListener("click", register());



