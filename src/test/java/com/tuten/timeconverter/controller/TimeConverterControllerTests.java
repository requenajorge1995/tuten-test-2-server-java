package com.tuten.timeconverter.controller;

import com.tuten.timeconverter.dto.ConvertedTimeDTO;
import com.tuten.timeconverter.dto.InputTimeDTO;
import com.tuten.timeconverter.service.TimeConverterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TimeConverterControllerTests {
    @Mock
    private TimeConverterService timeConverter;

    @InjectMocks
    private TimeConverterController controller;

    @Test
    void runTest() {
        ConvertedTimeDTO convertedTime = new ConvertedTimeDTO("12:30:00", "UTC");
        when(timeConverter.convert(any(InputTimeDTO.class))).thenReturn(convertedTime);

        ResponseEntity<ConvertedTimeDTO> res = controller.run(new InputTimeDTO("00:00:00", 0));
        Assertions.assertEquals(HttpStatus.OK, res.getStatusCode());
        Assertions.assertNotNull(res.getBody());
        Assertions.assertEquals("12:30:00", res.getBody().getTime());
        Assertions.assertEquals("UTC", res.getBody().getTimeZone());
    }
}
