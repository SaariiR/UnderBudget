package controllers;

import play.data.validation.Check;
import play.mvc.*;

@Check("admin")
@With(Secure.class)
public class Users extends CRUD {    
}