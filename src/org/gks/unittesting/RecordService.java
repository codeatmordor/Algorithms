
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.unittesting;

public class RecordService {

    private DatabaseDao dbDao;
    private NetworkDao nDao;

    public boolean save(String filename) {
        dbDao.save(filename);
        nDao.save(filename);
        return true;
    }
}
