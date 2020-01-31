<html lang="en">
<head>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="273754675187-9rlbmfmo4b4u15h887kkaj9nljgpuajv.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>
<#--<div class="container">-->
<#--    <div class="row">-->
<#--        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">-->
<#--            <div class="card card-signin my-5">-->
<#--                <div class="card-body">-->
<#--                    <h5 class="card-title text-center">Sign In</h5>-->
<#--                    <form class="form-signin">-->
<#--                        <div class="form-label-group">-->
<#--                            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>-->
<#--                            <label for="inputEmail">Email address</label>-->
<#--                        </div>-->

<#--                        <div class="form-label-group">-->
<#--                            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>-->
<#--                            <label for="inputPassword">Password</label>-->
<#--                        </div>-->

<#--                        <div class="custom-control custom-checkbox mb-3">-->
<#--                            <input type="checkbox" class="custom-control-input" id="customCheck1">-->
<#--                            <label class="custom-control-label" for="customCheck1">Remember password</label>-->
<#--                        </div>-->

<#--                        <hr class="my-4">-->
<#--                        <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign in with Google</button>-->

<#--                        <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>-->
<#--                    </form>-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->
<#--    </div>-->
<#--</div>-->

<div class="g-signin2" data-onsuccess="onSignIn" ></div>
<script>
    function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
    }
</script>
</body>
</html>