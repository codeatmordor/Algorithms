package org.gk.unittesting;

import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class RecordServiceTest {
    @Mock
    DatabaseDao dbDao;

    @Mock
    NetworkDao nDao;
}
