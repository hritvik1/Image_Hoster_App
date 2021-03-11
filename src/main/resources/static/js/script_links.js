'use strict'

function disableLoginBtn() {
    document.getElementById("loginBtn").style.display = "none"
    document.getElementById("signupBtn").style.marginRight = "80%"
}

function disableSignupBtn() {
    document.getElementById("signupBtn").style.display = "none"
    document.getElementById("loginBtn").style.marginRight = "80%"
}

function disableUploadBtn() {
    document.getElementById("uploadBtn").style.display = "none"
    document.getElementById("logoutBtn").style.marginRight = "71%"
}