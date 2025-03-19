<!DOCTYPE html>
<html>
<head>
    <title>Verify OTP</title>
</head>
<body>
    <h2>Enter OTP sent to your email</h2>
    <form action="verifyOtp" method="post">
        <input type="hidden" name="email" value="<%= request.getParameter("email") %>">
        <input type="text" name="otp" placeholder="Enter OTP" required>
        <button type="submit">Verify</button>
    </form>
</body>
</html>
