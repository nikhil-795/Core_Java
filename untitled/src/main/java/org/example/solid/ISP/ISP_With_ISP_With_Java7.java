package org.example.solid.ISP;

interface Document1{
    void open();
}

interface ValidateOperation{
    void validate();
}

interface ScanOperation{
    void scan();
}

interface SaveOperation{
    void save();
}

interface EditOperation{
    void edit();
}

class BaseDocument1 implements Document1, SaveOperation{

    @Override
    public void open() {
    }
    @Override
    public void save() {
    }
}

class AdvanceDocument1 implements Document1,
        SaveOperation,ScanOperation,ValidateOperation,EditOperation{

    @Override
    public void open() {
    }
    @Override
    public void save() {
    }
    @Override
    public void scan() {
    }
    @Override
    public void validate() {
    }
    @Override
    public void edit() {
    }
}

class VirtualDocument1 implements Document1,ScanOperation,EditOperation{

    @Override
    public void open() {
    }
    @Override
    public void scan() {
    }
    @Override
    public void edit() {
    }
}

class HardDocument1 implements Document1{

    @Override
    public void open() {
    }
}
// All the classes/documents implements the Document interface & got all the methods but
// does all the subclasses/documents really need all the methods of interface ? ->  No

// BaseDocument -> only need => open , save
// AdvanceDocument -> only need => open , save , scan, validate, edit
// VirtualDocument -> only need => open , scan, edit
// HardDocument -> only need => open

public class ISP_With_ISP_With_Java7 {

    public static void main(String... r){
    }
}
