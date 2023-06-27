package com.ftn.szz.model;

import com.ftn.szz.model.enums.ENotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private ENotificationStatus status;
    private JobAlert jobAlert;
}

