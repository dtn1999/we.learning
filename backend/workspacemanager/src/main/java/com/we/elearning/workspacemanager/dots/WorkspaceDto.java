package com.we.elearning.workspacemanager.dots;

import com.we.elearning.workspacemanager.entities.WorkspaceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkspaceDto {
    private Long id;
    private String runnerId;
    private String host;
    private int port;

    private WorkspaceStatus status;
    private WorkspaceVolumeDto workspaceVolume;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
