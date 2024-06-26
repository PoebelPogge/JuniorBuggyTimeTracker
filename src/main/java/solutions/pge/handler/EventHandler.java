package solutions.pge.handler;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import solutions.pge.models.business.Club;
import solutions.pge.models.business.Driver;
import solutions.pge.models.business.Event;

import java.time.OffsetDateTime;
import java.util.List;

@ApplicationScoped
public class EventHandler {

    private final DriverHandler driverHandler;

    @Inject
    public EventHandler(DriverHandler driverHandler) {
        this.driverHandler = driverHandler;
    }

    @ConfigProperty(name = "event.race-amount")
    public Integer raceAmount;


    public Event createEvent(){
        List<Driver> drivers = driverHandler.findALl();

        Event event = new Event(
                "Oldenburg",
                        new Club("Oldenburg","Oldenburg"),
                OffsetDateTime.now(),
                2,
                23.0
                );

        return event;
    }
}
