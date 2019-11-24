package com.guoguo.ningxing.dao.record;

import com.guoguo.ningxing.entity.record.Record;

import java.util.Date;

public interface RecordDao {

    void addRecord(Record record);

    void updateRecordById(Record record);

    Record getRecordByAddTime(Date date);
}
