// BookingController.js

const express = require('express');
const router = express.Router();
const BookingService = require('../services/BookingService'); // Adjust path as necessary

// Get all bookings
router.get('/', async (req, res) => {
  try {
    const bookings = await BookingService.getAllBookings();
    res.status(200).json(bookings);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

// Create a booking
router.post('/users/:uid/showtimes/:sid', async (req, res) => {
  try {
    const { uid, sid } = req.params;
    const booking = req.body;
    const newBooking = await BookingService.addBooking(uid, sid, booking);
    res.status(201).json(newBooking);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

// Delete a booking
router.delete('/:id', async (req, res) => {
  try {
    const bookingId = parseInt(req.params.id, 10);
    await BookingService.deleteBooking(bookingId);
    res.status(204).send();
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

// Update a booking
router.put('/:id', async (req, res) => {
  try {
    const bookingId = parseInt(req.params.id, 10);
    const updatedBooking = await BookingService.updateBooking(bookingId, req.body);
    res.status(200).json(updatedBooking);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

module.exports = router;