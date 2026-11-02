using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.NationalDebt
{
    /// <summary>
    /// Query options for the National Debt API
    /// </summary>
    public class NationalDebtQueryOptions
    {
        /// <summary>
        /// Optional date in YYYY-MM-DD format for historical lookup. Omit for current data.
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }

        /// <summary>
        /// Include the previous record's total and the growth over 1 day, 30 days and 1 year
        /// </summary>
        [JsonProperty("changes")]
        public bool? Changes { get; set; }
    }
}
