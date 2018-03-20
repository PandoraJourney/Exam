import { Service } from 'react-services-injector';

class UserService extends Service {
  constructor() {
    super();
    // this.setUser(null);
    this.User='';
  }

  setUser(user) {
    this.User = user;
  }

  get user() {
    //we can store pure data and format it in getters
    return this.User;
  }
}

UserService.publicName = 'UserService';

export default UserService;