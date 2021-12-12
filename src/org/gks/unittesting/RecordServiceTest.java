package org.gks.unittesting;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RecordServiceTest {
    @Mock
    DatabaseDao dbDao;

    @Mock
    NetworkDao nDao;
}
