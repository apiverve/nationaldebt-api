declare module '@apiverve/nationaldebt' {
  export interface nationaldebtOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface nationaldebtResponse {
    status: string;
    error: string | null;
    data: NationalDebtData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface NationalDebtData {
      date:                           Date | null;
      totalDebt:                      number | null;
      totalDebtFormatted:             null | string;
      publicDebt:                     number | null;
      publicDebtFormatted:            null | string;
      intragovernmentalDebt:          number | null;
      intragovernmentalDebtFormatted: null | string;
      perCapita:                      number | null;
      perCapitaFormatted:             null | string;
      population:                     number | null;
      publicDebtRatio:                number | null;
      perHousehold:                   number | null;
      perHouseholdFormatted:          null | string;
  }

  export default class nationaldebtWrapper {
    constructor(options: nationaldebtOptions);

    execute(callback: (error: any, data: nationaldebtResponse | null) => void): Promise<nationaldebtResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: nationaldebtResponse | null) => void): Promise<nationaldebtResponse>;
    execute(query?: Record<string, any>): Promise<nationaldebtResponse>;
  }
}
