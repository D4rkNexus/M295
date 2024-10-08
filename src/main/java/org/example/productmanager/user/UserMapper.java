package org.example.productmanager.user;

import org.example.productmanager.products.dto.ProductCreateDto;
import org.example.productmanager.products.dto.ProductUpdateDto;
import org.example.productmanager.user.dto.RegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    // Einfaches Mapping für die Erstellung einer neuen Benutzerentität
    public abstract UserData ProductCreateDto(ProductCreateDto userData);

    // Einfaches Mapping für die Anzeige eines Benutzers
    public abstract UserData ProductShowDto(UserData userData);

    // Einfaches Mapping für die Anzeige der Benutzerdetails
    public abstract UserData ProductDetailDto(UserData userData);

    // Einfaches Mapping für das Aktualisieren eines Benutzers
    public abstract void ProductUpdateDto(ProductUpdateDto userData, @MappingTarget UserData existingUserData);

    public abstract UserData fromRegisterDto(RegisterDto registerDto);
}