package com.example.adrian.homeautomationaccessmobile.test;

import com.example.adrian.homeautomationaccessmobile.interactor.control.GetControlsEvent;
import com.example.adrian.homeautomationaccessmobile.model.ControlItem;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GetControlsEventUnitTest {

    GetControlsEvent gce;

    @Before
    public void setup(){
        gce = new GetControlsEvent();
    }

    @Test
    public void getControlsSetCode(){
        gce.setCode(1);
        assertEquals(1, gce.getCode());
    }

    @Test
    public void getControlsGetCode(){
        gce.setCode(10);
        assertEquals(10, gce.getCode());
    }

    @Test
    public void getControlsSetControl(){
        ArrayList<ControlItem> controls = new ArrayList<>();
        controls.add(new ControlItem("1", "2", "3", "4"));
        controls.add(new ControlItem("10", "20", "30", "40"));
        controls.add(new ControlItem("100", "200", "300", "400"));
        gce.setControls(controls);
        assertEquals(3, gce.getControls().size());
    }

    @Test
    public void getControlsGetControl(){
        ArrayList<ControlItem> controls = new ArrayList<>();
        controls.add(new ControlItem("1", "2", "3", "4"));
        controls.add(new ControlItem("10", "20", "30", "40"));
        controls.add(new ControlItem("100", "200", "300", "400"));
        gce.setControls(controls);
        assertEquals(controls.get(0), gce.getControls().get(0));
    }

    @Test
    public void getControlsSetThrowable(){
        gce.setThrowable(new Throwable());
        assertNotEquals(null, gce.getThrowable());
    }

    @Test
    public void getControlsGetThrowable(){
        Throwable t = new Throwable();
        gce.setThrowable(t);
        assertEquals(t, gce.getThrowable());
    }
}
