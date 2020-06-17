-- Story 601032, Task 662352  Adds new column to hold multiple station ids assigned to a user.
ALTER TABLE ERX.VA_USER ADD VA_STATION_IDS VARCHAR2(3000 BYTE)    DEFAULT 'All' NOT NULL;