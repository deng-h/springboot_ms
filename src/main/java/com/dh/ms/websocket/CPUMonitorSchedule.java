package com.dh.ms.websocket;

import com.dh.ms.Utils.CPUMonitor;
import com.dh.ms.components.WebSocketServer;
import com.dh.ms.vo.ResultVO;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@EnableScheduling
public class CPUMonitorSchedule {
    @Scheduled(fixedRate = 1000)
    private void configureTasks() throws IOException {
        Map<String, Object> map = new HashMap<>();
        float[] list = new float[1];
        list[0] = (float) CPUMonitor.getInstance().getCPUUsage();
        map.put("data", list);
        ResultVO resultVO = ResultVO.success("连接成功", list);
        WebSocketServer.sendMessage(resultVO);
    }
}
