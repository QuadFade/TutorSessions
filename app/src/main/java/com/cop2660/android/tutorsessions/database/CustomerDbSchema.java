package com.cop2660.android.tutorsessions.database;

public class CustomerDbSchema {
    public static final class CustomerTable {
        public static final String NAME = "customers";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String PN = "phoneNumber";
            public static final String EA = "emailAddress";
        }
    }
}
