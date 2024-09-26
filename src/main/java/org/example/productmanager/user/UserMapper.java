package org.example.productmanager.user;

import org.example.productmanager.user.UserData;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    // Einfaches Mapping für die Erstellung einer neuen Benutzerentität
    public abstract UserData toEntity(UserData userData);

    // Einfaches Mapping für die Anzeige eines Benutzers
    public abstract UserData toShowDto(UserData userData);

    // Einfaches Mapping für die Anzeige der Benutzerdetails
    public abstract UserData toDetailDto(UserData userData);

    // Einfaches Mapping für das Aktualisieren eines Benutzers
    public abstract void update(UserData userData, @MappingTarget UserData existingUserData);
}