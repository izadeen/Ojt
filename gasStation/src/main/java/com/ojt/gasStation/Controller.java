package com.ojt.gasStation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private GasStation gasStation=GasStation.getInstance();

    @GetMapping("/Vehicles")
    public List<Vehicle> getVehicls(){
        return gasStation.getServiceList();
    }

    @GetMapping("/vehicle/{id}")
    public Status getStatus(@PathVariable Integer id){
        return gasStation.getStatus(id);
    }
}
