package sctp.ntu.booking_api.services;

import java.util.ArrayList;

import sctp.ntu.booking_api.entities.CloudImage;
import sctp.ntu.booking_api.entities.Event;

public interface CloudImageService {

  CloudImage addCloudImage(int eid, CloudImage cloudImage);

}
