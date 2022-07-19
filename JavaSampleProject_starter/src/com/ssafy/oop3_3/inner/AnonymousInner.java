package com.ssafy.oop3_3.inner;

public class AnonymousInner {
    public Folder gotNewFolder() {
        return new Folder() {
            public void open() { /* */ }

            public void fold() { /* */ }
        };
    }
}

interface Folder {
    public void open();

    public void fold();
}