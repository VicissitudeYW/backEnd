package org.example.pojo;

public class Router {
    private String role;

    private String route;

    private String active_name;

    public Router(String role, String route, String active_name) {
        this.role = role;
        this.route = route;
        this.active_name = active_name;
    }

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public String getRoute() {return route;}

    public void setRoute(String route) {this.route = route;}

    public String getActive_name() {return active_name;}

    public void setActive_name(String active_name) {this.active_name = active_name;}
}
