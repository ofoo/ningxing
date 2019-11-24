package com.guoguo.ningxing.service.record;

import com.guoguo.ningxing.dao.record.RecordDao;
import com.guoguo.ningxing.entity.record.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RecordService {
    @Autowired
    private RecordDao recordDao;

    public void addRecord(Record record) {
        Date date = new Date();
        record.setAddTime(date);
        recordDao.addRecord(record);
    }

    public void updateRecordById(Record record) {
        recordDao.updateRecordById(record);
    }

    public Record getRecordByAddTime(Date date) {
        return recordDao.getRecordByAddTime(date);
    }
}
