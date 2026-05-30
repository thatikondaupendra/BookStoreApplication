<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Page</title>
    <style>
        header{
            background: #2d3436;
            padding: 20px;
            text-align: center;
            color: #fff;
            letter-spacing: 2px;
            font-size: 28px;
            font-weight: bold;
        }
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            padding: 40px;
        }
        .payment-container {
            width: 400px;
            margin: auto;
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px #ccc;
        }
        .payment-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
            display: block;
            margin: 10px 0 5px;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .btn {
            background: #28a745;
            color: #fff;
            border: none;
            padding: 12px;
            border-radius: 5px;
            width: 100%;
            font-size: 16px;
            cursor: pointer;
        }
        .btn:hover {
            background: #218838;
        }
        button {
  padding: 12px 25px;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
  background: #ffd700;
  color: #333;
  transition: transform 0.3s ease, background 0.3s ease;
}

button:hover {
  background: #f4c430;
  transform: scale(1.05);
}
    </style>

</head>
<body>
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>

    <div class="payment-container">
        <h2>Payment Details</h2>
        <form action="buynow" method="post">
            
            <!-- Cardholder Name -->
            
                        <%System.out.println(request.getAttribute("username")+"_______________________--------__"); %>
            <input type="hidden" name="username" value="<%=request.getAttribute("username") %>">
            
                        
            <input type="hidden"  name="bookname" value="<%=request.getAttribute("bookname") %>">
            
                       
            <input type="hidden"  name="author" value="<%=request.getAttribute("author") %>">
            
            <label for="cardName">Customer Name</label>
            <input type="text" id="cardName" name="cardName" required>
            
            <!-- Card Number -->
            <label for="cardNumber">Acc No</label>
            <input type="text" id="cardNumber" name="cardNumber" maxlength="16" required>
            
            <!-- Expiry Date -->

            <label for="expiry"> Date of delivary you want</label>  <form>
  <label for="bookingDate">Choose a date:</label>
  <input type="date" id="bookingDate" name="bookingDate" required>
  <p id="message"></p>

  <script>
    // Get today's date in YYYY-MM-DD format
    const today = new Date();
    const yyyy = today.getFullYear();
    const mm = String(today.getMonth() + 1).padStart(2, "0");
    const dd = String(today.getDate()).padStart(2, "0");
    const minDate = yyyy + "-" + mm + "-" + dd;

    const bookingDate = document.getElementById("bookingDate");
    const message = document.getElementById("message");

    // Set the minimum date (disables past dates)
    bookingDate.setAttribute("min", minDate);

    // Listen for date change
    bookingDate.addEventListener("change", function () {
      const selectedDate = new Date(this.value);
      const todayDate = new Date(minDate);
      
      if (selectedDate < todayDate) {
        message.textContent = "❌ You cannot select a past date!";
        message.className = "invalid";
        this.value = ""; // Clear invalid date
      } else {
        message.textContent = "✅ Valid date selected.";
        message.className = "valid";
      }
    });
  </script>
            <!-- CVV -->
            <label for="cvv">pass key</label>
            <input type="password" id="cvv" name="cvv" maxlength="3" required>
            
            <!-- Payment Method -->
            <label for="paymentMethod">Payment Method</label>
            <select id="paymentMethod" name="paymentMethod" required>
                <option value="credit">Credit Card</option>
                <option value="debit">Debit Card</option>
                <option value="netbanking">Net Banking</option>
                <option value="upi">UPI</option>
            </select>
            
            <!-- Billing Address -->
            <label for="address">Billing Address</label>
            <input type="text" id="address" name="address" required>
            
            <!-- Submit -->
            <button type="submit" class="btn">Pay Now</button>
        </form>
    </div>
</body>
</html>
