package service;

import dao.MockDataDao;
import pojo.MockContent;

import java.util.List;

/**
 * Created by barryfan on 6/17/19.
 */
public class MockService {

    private MockDataDao mockDataDao = new MockDataDao();

    public void addMockData(MockContent mockContent) {
        String key = mockContent.getRequestContent().getUri().concat("-")
                .concat(mockContent.getRequestContent().getMethod().toUpperCase());
        if (mockDataDao.getMockData(key) == null) {
            mockDataDao.addMockData(key, mockContent);
        }
    }

    public void modifyMockData(MockContent mockContent) {
        String key = mockContent.getRequestContent().getUri().concat("-")
                .concat(mockContent.getRequestContent().getMethod().toUpperCase());
        if (mockDataDao.getMockData(key) != null) {
            mockDataDao.updateMockData(key, mockContent);
        }
    }

    public void deleteMockData(MockContent mockContent) {
        String key = mockContent.getRequestContent().getUri().concat("-")
                .concat(mockContent.getRequestContent().getMethod().toUpperCase());
        mockDataDao.deleteMockData(key);
    }

    public MockContent getMockData(String key) {
        return mockDataDao.getMockData(key);
    }

    public List<MockContent> getAllMockData() {
        return mockDataDao.getAllMockData();
    }
}
