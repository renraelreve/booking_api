package sctp.ntu.booking_api.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sctp.ntu.booking_api.entities.CloudImage;
import sctp.ntu.booking_api.entities.Event;
import sctp.ntu.booking_api.repositories.CloudImageRepository;
import sctp.ntu.booking_api.repositories.EventRepository;
import sctp.ntu.booking_api.services.CloudImageService;

@Service
public class CloudImageServiceImpl implements CloudImageService {

  private final CloudImageRepository cloudImageRepository;
  private final EventRepository eventRepository;

  @Autowired
  public CloudImageServiceImpl(CloudImageRepository cloudImageRepository, EventRepository eventRepository) {
    this.cloudImageRepository = cloudImageRepository;
    this.eventRepository = eventRepository;
  }

  @Override
  public CloudImage addCloudImage(int eid, CloudImage cloudImage) {
    Event event = eventRepository.findById(eid).orElseThrow(() -> new RuntimeException("Event not found"));
    cloudImage.setEvent(event);
    return cloudImageRepository.save(cloudImage);
  }

}
