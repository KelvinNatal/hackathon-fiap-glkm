package com.fiap.hackathon.reservation.dto;

import java.util.List;
import java.util.UUID;

public record ReservationAddItemRequestDTO(
        List<UUID> itemList
) {
}
