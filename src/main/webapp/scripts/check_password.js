function checkPass() {
    if (document.getElementById('password1').value != document.getElementById('password2').value) {
        alert('Проверьте пароль, пожалуйста')
        return false;
    } else return true;
}

