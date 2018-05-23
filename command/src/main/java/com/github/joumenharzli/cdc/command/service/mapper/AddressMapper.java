/*
 * Copyright (C) 2018 Joumen Harzli
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package com.github.joumenharzli.cdc.command.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.joumenharzli.cdc.command.domain.Address;
import com.github.joumenharzli.cdc.command.service.dto.AddressDto;

/**
 * AddressMapper
 *
 * @author Joumen Harzli
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {

  @Mapping(target = "id",
      expression = "java( address.getId() == null ? null : java.util.UUID.fromString(address.getId()) )",
      ignore = true)
  Address toEntity(AddressDto address);

  List<Address> toEntities(List<Address> addresss);

  @Mapping(target = "id",
      expression = "java( address.getId() == null ? null : address.getId().toString() )",
      ignore = true)
  AddressDto toDto(Address address);

  List<AddressDto> toDtos(List<Address> address);


}