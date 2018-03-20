import { Service } from 'react-services-injector';

class EventEmitter extends Service{
  constructor() {
    super();
    this._subscribers = [];
  }
  
  subscribe(sub, handler, eventType){
    this._subscribers.push({
      sub: sub,
      handler: handler,
      eventType: eventType
    });
    console.log('subscribed');
  }


 unsubscribe(subToUnsubscribe){
    this._subscribers = this._subscribers.filter((sub)=> { return sub.sub !== subToUnsubscribe; });
  }

  publish(event){
    console.log('publish called');
    this._subscribers.filter((sub) =>{ return sub.eventType === event.eventType || !sub.eventType; })
      .forEach((sub)=> {sub.handler(event);});
  };
}

EventEmitter.publicName = 'EventEmitter';

export default EventEmitter;
