package org.example.pojo;

public class Router {
    private String role;

    private String route;

    private String activeName;

    public Router(String role, String route, String activeName) {
        this.role = role;
        this.route = route;
        this.activeName = activeName;
    }

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public String getRoute() {return route;}

    public void setRoute(String route) {this.route = route;}

    public String getActiveName() {return activeName;}

    public void setActiveName(String activeName) {this.activeName = activeName;}
}
