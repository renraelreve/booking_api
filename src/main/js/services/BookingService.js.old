// BookingService.js

const bookings = []; // Mock database

const BookingService = {
  getAllBookings: async () => {
    return bookings;
  },

  addBooking: async (userId, showtimeId, booking) => {
    booking.bid = bookings.length + 1; // Mock ID assignment
    bookings.push(booking);
    return booking;
  },

  deleteBooking: async (bookingId) => {
    const index = bookings.findIndex(b => b.bid === bookingId);
    if (index !== -1) {
      bookings.splice(index, 1);
    }
  },

  updateBooking: async (bookingId, updatedBooking) => {
    const index = bookings.findIndex(b => b.bid === bookingId);
    if (index !== -1) {
      bookings[index] = { ...bookings[index], ...updatedBooking };
      return bookings[index];
    }
    return null;
  }
};

module.exports = BookingService;