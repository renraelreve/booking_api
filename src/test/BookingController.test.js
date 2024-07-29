const request = require('supertest');
const express = require('express');
const BookingController = require('../main/js/controller/BookingController'); 
const BookingService = require('../main/js/services/BookingService');

jest.mock('../main/js/services/BookingService');

const app = express();
app.use(express.json());
app.use('/api/bookings', BookingController);

describe('BookingController', () => {
  beforeEach(() => {
    jest.clearAllMocks();
  });

  test('should get all bookings', async () => {
    // Setup
    const bookings = [{ id: 1, name: 'Booking 1' }];
    BookingService.getAllBookings.mockResolvedValue(bookings);

    // Execute
    const response = await request(app).get('/api/bookings');

    // Assert
    expect(response.status).toBe(200);
    expect(response.body).toHaveLength(1);
  });

  test('should delete a booking', async () => {
    // Mock
    BookingService.deleteBooking.mockResolvedValue();

    // Execute
    const response = await request(app).delete('/api/bookings/1');

    // Assert
    expect(response.status).toBe(204);

    // Verify
    expect(BookingService.deleteBooking).toHaveBeenCalledWith(1);
    expect(BookingService.deleteBooking).toHaveBeenCalledTimes(1);
  });

  test('should create a booking', async () => {
    // Setup
    const booking = { id: 1, name: 'Booking 1' };
    BookingService.addBooking.mockResolvedValue(booking);

    // Execute
    const response = await request(app)
      .post('/api/bookings/users/1/showtimes/1')
      .send({ userId: 1, eventId: 1, booking });

    // Assert
    expect(response.status).toBe(201);
    expect(response.body).toEqual(booking);
  });
});