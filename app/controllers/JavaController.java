package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class JavaController extends Controller {


    public Result ping(Http.Request request) {
        String msg = request.getQueryString("msg");
        return ok("Java Pong " + msg);

    }
}
