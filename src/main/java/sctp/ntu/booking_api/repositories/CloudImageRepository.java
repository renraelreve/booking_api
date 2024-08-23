package sctp.ntu.booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sctp.ntu.booking_api.entities.CloudImage;

public interface CloudImageRepository extends JpaRepository<CloudImage, Integer> {
}
