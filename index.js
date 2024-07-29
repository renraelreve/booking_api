require("dotenv").config();
const express = require('express');
const app = express();
const BookingController = require('./controllers/BookingController'); // Adjust path as necessary

app.use(express.json());
app.use('/api/bookings', BookingController);

app.listen(process.env.PORT, () => {
  console.log(`Listening to port ${process.env.PORT}`);
});