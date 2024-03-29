package com.we.elearning.workspacemanager.services.providers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RunnerDetails {
    private String id;
    private String name;
    private String host;
    private int port;
    private VolumeDetails volume;
}
