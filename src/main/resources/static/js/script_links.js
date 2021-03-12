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

function fileValidate() {
    const file     = document.getElementById("image"),
          fileSize = (file.files.item(0).size)/(1024*1024)

    if(fileSize > 10) {
        alert("File Size Must Be Less Than 10 MB")
        return false
    }
    return true
}