<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Facebook-Login or Sign up</title>
    <link rel="stylesheet" href="/login_page_style.css">
</head>
<body>
<main>
    <div class="row">
        <div class="colm-logo">
            <img src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg" alt="Logo">
            <h2>Some text in witch no one interested to read.</h2>
        </div>
        <div class="colm-form">
            <div class="form-container">
                <form action="login-check" method="post">
                    <input type="text" name="login" placeholder="Login">
                    <input type="password" name="password" placeholder="Password">
                    <button class="btn-login" th:value="login-check">Sign in</button>
                </form>
                <#if error??><a>${error}</a><#else></#if>
            </div>
        </div>
    </div>
</main>
</body>
</html>