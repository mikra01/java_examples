package payload.sender;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import event.EventType;
import event.EventValue;
import payload.EventPayload;


@Named
@ApplicationScoped
public class EventSender {

	  @Inject
	  @EventType(value = EventValue.SayHello)
	  Event<EventPayload>helloEvent;
	
	  @Inject
	  @EventType(value = EventValue.SayGoodBye)
	  Event<EventPayload>goodByeEvent;
	  
	  
	  public void doSayHello(EventPayload pl) {
		  this.helloEvent.fire(pl);
	  }
	  
	  public void doSayGoodBye(EventPayload pl){
		 this.goodByeEvent.fire(pl);
	  }
	  
}
