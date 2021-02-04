package com.redhat.rest;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.redhat.model.Port;
import com.redhat.model.Ship;
import com.redhat.model.Shipment;


@Path("/shipments")
public class ShipmentResource {

    @GET
    public List<Shipment> allShipments() {
        return Shipment.listAll();
    }

    @GET
    @Path("/init")
    @Transactional
    public void initShipments() {
        Shipment shipment = new Shipment();
        shipment.ship = Ship.find("name","Big Ship").firstResult();
        shipment.startPort = Port.find("name","London").firstResult();
        shipment.endPort = Port.find("name","Halifax").firstResult();
        shipment.persist();
        
    }
}