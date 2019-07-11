package dao;

import pojo.MockContent;

import java.util.*;

/**
 * Created by barryfan on 6/17/19.
 */
public class MockDataDao {

    // 时间复杂度为1
    public static final Map<String, MockContent> MockData =
            new HashMap();


    public void addMockData(String key, MockContent mockContent) {
        MockData.put(key, mockContent);
    }

    public void deleteMockData(String key) {
        MockData.remove(key);
    }

    public void updateMockData(String key, MockContent mockContent) {
        MockData.put(key, mockContent);
    }

    public MockContent getMockData(String key) {
        return MockData.get(key);
    }

    public List<MockContent> getAllMockData() {
        return Collections.list(Collections.enumeration(MockData.values()));
    }


}
